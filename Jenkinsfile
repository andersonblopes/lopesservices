node{
    stage('SCM checkout'){
        git branch: 'main', credentialsId: 'github', url: 'https://github.com/andersonblopes/lopesservices.git'
    }

    stage('Compile-Package'){
        // get maven home path
        def mavenHome = tool name: 'maven-3', type: 'maven'
        sh "${mavenHome}/bin/mvn clean package"
    }
    stage('SonarQube analysis') {
        def mavenHome = tool name: 'maven-3', type: 'maven'
        withSonarQubeEnv('sonarqube-10') { // If you have configured more than one global server connection, you can specify its name
          sh "${scannerHome}/bin/sonar-scanner"
        }
      }
}
