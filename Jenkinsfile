node{
    stage('SCM checkout'){
        git branch: 'main', credentialsId: 'github', url: 'https://github.com/andersonblopes/lopesservices.git'
    }

    stage('Compile-Package'){
        // get maven home path
        def mavenHome = tool name: 'maven-3', type: 'maven'
        sh "${mavenHome}/bin/mvn clean package"
    }

    stage('SonarQube Analysis') {
      def mvn = tool 'maven-3';
      //def scannerHome = tool 'sonarqube-10';
      withSonarQubeEnv() {
        "${mvn}/bin/mvn clean verify sonar:sonar -Dsonar.projectKey=lopesservices -Dsonar.projectName='lopesservices'"
        //sh "${scannerHome}/bin/sonar-scanner"
      }
    }
}
