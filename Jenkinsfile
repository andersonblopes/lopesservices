properties([gitLabConnection(gitLabConnection: '', jobCredentialId: ''), parameters([[$class: 'CascadeChoiceParameter', choiceType: 'PT_SINGLE_SELECT', filterLength: 1, filterable: false, name: 'BRANCH', randomName: 'choice-parameter-24908911173004', referencedParameters: '', script: [$class: 'GroovyScript', fallbackScript: [classpath: [], oldScript: '', sandbox: false, script: ''], script: [classpath: [], oldScript: '', sandbox: false, script: '''def gettags = ("git ls-remote -t -h https://github.com/andersonblopes/lopesservices").execute()
return gettags.text.readLines().collect {
  it.split()[1].replaceAll(\'refs/heads/\', \'\').replaceAll(\'refs/tags/\', \'\').replaceAll("\\\\^\\\\{\\\\}", \'\')
}''']]]])])
node{
    stage('SCM checkout'){
        sh "echo sh branch selected: ${params.branch}"
        git branch: '$BRANCH', url: 'https://github.com/andersonblopes/lopesservices.git'
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

