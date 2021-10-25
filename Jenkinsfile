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

		stage('Docker Hub Login') {

			steps {
				sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
			}
		}

		stage('Push Image To Docker Hub') {

			steps {
				sh 'docker push akashnewscapepune/productimg:latest'
			}
		}
		stage('Deploy to K8s')
		{
			steps{
					sh 'kubectl get pod'
					//sh 'scp -r -o StrictHostKeyChecking=no deployment.yml root@10.14.21.80:/root/Desktop/dockerImages'
					
					script{
						try{
							sh 'kubectl apply -f deployment.yaml --kubeconfig=/root/.kube/kube.yaml'

							}catch(error)
							{
								sh 'kubectl create -f deployment.yaml'

							}
					}
			}
		}
		
	}

	post {
		always {
			sh 'docker logout'
		}
	}

}
