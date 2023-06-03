node{
    stage('SCM checkout'){
        git 'https://github.com/andersonblopes/lopesservices'
    }

    stage('Compile-Package'){
        // get maven home path
        def mavenHome = tool name: 'maven-3', type: 'maven'
        sh "${mavenHome}/bin/mvn clean package"
    }
}
