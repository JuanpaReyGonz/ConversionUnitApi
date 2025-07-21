pipeline {
    agent any
    environment {
        IMAGE_NAME = 'juanpareygonz/conversion-unit-api'
        IMAGE_TAG = 'latest'
    }
    stages {
        stage('Clear WorkSpace') {
            steps {
                script {
                    sh 'rm -rf ./*'
                }
            }
        }
        stage('Git Clone') {
            steps {
                withCredentials([string(credentialsId:'GITHUB_PAT', variable:'GITHUB_TOKEN')]){
                    script {
                        sh 'git clone https://JuanpaReyGonz:$GITHUB_TOKEN@github.com/JuanpaReyGonz/ConversionUnitApi.git'
                    }
                }
            }
        }
        stage('Run Unit Tests') {
            steps {
                dir('ConversionUnitApi') {
                    sh 'mvn test'
                }
            }
        }
        stage('Build Docker Image') {
            steps {
                dir('ConversionUnitApi') {
                    sh 'docker build -t ${env.IMAGE_NAME}:${env.IMAGE_TAG} .'
                }
            }
        }
        stage('Run Docker Container') {
            steps {
                script {
                    sh 'docker rm -f conversion-unit-api || true'
                    sh "docker run -d -p 8081:8081 --name conversion-unit-api ${env.IMAGE_NAME}:${env.IMAGE_TAG}"
                }
            }
        }
    }
}
