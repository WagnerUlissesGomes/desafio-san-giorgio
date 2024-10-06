package br.com.desafio.infra.provider.queue;

import br.com.desafio.domain.model.PaymentModel;
import br.com.desafio.domain.model.PaymentStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;

//@Component
public class AwsSQS {

    @Autowired
    private SqsClient sqsClient;

    @Value("${aws.sqs.queue.partial}")
    private String partialQueue;

    @Value("${aws.sqs.queue.total}")
    private String totalQueue;

    @Value("${aws.sqs.queue.excess}")
    private String excessQueue;

    public void sendToQueue(PaymentModel payment) {
        sqsClient.sendMessage(SendMessageRequest.builder()
                .queueUrl(getUrl(payment.getStatus()))
                .messageBody(payment.toString())
                .build());
    }

    private String getUrl(PaymentStatus status) {
        if (PaymentStatus.PARCIAL.equals(status)) {
            return partialQueue;
        } else if (PaymentStatus.EXCEDENTE.equals(status)) {
            return excessQueue;
        } else {
            return totalQueue;
        }
    }
}
