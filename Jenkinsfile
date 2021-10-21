pipeline{

	agent any

	environment {
		DOCKERHUB_CREDENTIALS=credentials('dockerhubstdin')
	}

	stages {

		stage('Build') {

			steps {
				sh 'mvn clean install'
				sh 'docker build -t akashnewscapepune/productimg:latest .'
			}
		}

		stage('Login') {

			steps {
				sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
			}
		}

		stage('Push') {

			steps {
				sh 'docker push akashnewscapepune/productimg:latest'
			}
		}
	}

	post {
		always {
			sh 'docker logout'
		}
	}

}
