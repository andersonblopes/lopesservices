node{
    stage('SCM checkout'){
        git branch: 'main', credentialsId: 'github', url: 'https://github.com/andersonblopes/lopesservices.git'
    }

    stage('Compile-Package'){
        // get maven home path
        def mavenHome = tool name: 'maven-3', type: 'maven'
        sh "${mavenHome}/bin/mvn package"
    }

    stage('SonarQube Analysis') {
      def mavenHome = tool name: 'maven-3', type: 'maven'
      withSonarQubeEnv("sonarqube-10") {
        "${mavenHome}/bin/mvn sonar:sonar"
      }
    }
}
