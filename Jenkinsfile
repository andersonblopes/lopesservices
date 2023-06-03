node{
    stage('SCM checkout'){
        git branch: 'main', credentialsId: 'github', url: 'https://github.com/andersonblopes/lopesservices.git'
    }

    stage('Compile-Package'){
        // get maven home path
        def mavenHome = tool name: 'maven-3', type: 'maven'
        sh "${mavenHome}/bin/mvn clean package"
    }
}
