pipeline {
agent any
tools { 
maven 'mavendev'

}
stages {
stage("Code checkout"){
steps {
git branch: 'development', credentialsId: 'github', url: ''
}
}
stage("Build"){
steps{
sh 'mvn clean install'
}
}
}
}
