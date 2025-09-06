# Use Amazon Corretto 17 as base
FROM public.ecr.aws/lambda/java:17

# Copy jar file
COPY target/springboot-lambda-stripe-0.0.1-SNAPSHOT.jar ${LAMBDA_TASK_ROOT}/

# Set the Lambda handler
CMD ["com.example.lambda.LambdaHandler::handleRequest"]
