pipeline {
agent any
tools { 
maven 'mavendev'

}
stages {
stage("Code checkout"){
steps {
git branch: 'development', credentialsId: 'github', url: 'https://github.com/mohammadaszadali/api-access-management-service.git'
}
}
stage("Build"){
steps{
sh 'mvn clean install'
}
}
}
}

