node{
    stage('SCM checkout'){
        git 'https://github.com/andersonblopes/lopesservices'
    }

    stage('Compile-Package'){
        sh 'mvn clean package'
    }
}
