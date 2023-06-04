pipeline{

    agent any

    properties([
        parameters([
            gitParameter(branch: '',
                         branchFilter: 'origin/(.*)',
                         defaultValue: 'master',
                         description: '',
                         name: 'BRANCH',
                         quickFilterEnabled: false,
                         selectedValue: 'NONE',
                         sortMode: 'NONE',
                         tagFilter: '*',
                         type: 'PT_BRANCH')
        ])
    ])

    stages{
        stage('SCM checkout'){
            sh "echo sh branch selected: ${params.BRANCH}"
            git branch: "${params.BRANCH}", url: 'https://github.com/andersonblopes/lopesservices.git'
        }

        stage('Compile-Build'){
            def mavenHome = tool name: 'maven-3', type: 'maven'
            sh "${mavenHome}/bin/mvn clean package install"
        }

        stage('Analysis') {
            def mavenHome = tool name: 'maven-3', type: 'maven'
          withSonarQubeEnv() {
            sh "${mavenHome}/bin/mvn sonar:sonar -Dsonar.projectKey=lopesservices -Dsonar.projectName='lopesservices'"
          }
        }

        stage("Quality Gate"){
            timeout(time: 1, unit: 'HOURS') {
                def qg = waitForQualityGate()
                if (qg.status != 'OK') {
                    error "Pipeline aborted due to quality gate failure: ${qg.status}"
                }
            }
        }
    }
}
