pipeline{
    stages{
        stage('Build'){
            steps{
                sh 'sbt compile'
            }
        }
        post{
            success{
                echo "project build success...!"
            }
            failure{
                echo "project build failed"
            }
        }
    }
}