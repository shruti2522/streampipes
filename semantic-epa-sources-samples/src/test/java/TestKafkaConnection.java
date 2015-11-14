import org.apache.commons.lang3.RandomStringUtils;

import de.fzi.cep.sepa.commons.messaging.IMessageListener;
import de.fzi.cep.sepa.commons.messaging.ProaSenseInternalProducer;
import de.fzi.cep.sepa.commons.messaging.kafka.KafkaConsumerGroup;


public class TestKafkaConnection implements IMessageListener {
	
	private static final int MAX_MESSAGES = 100;
	private int counter = 0;
	
	private ProaSenseInternalProducer producer;
	
	public TestKafkaConnection(String url, int kafkaTopic, int zookeeperTopic, String topic)
	{
		producer = new ProaSenseInternalProducer(url+kafkaTopic, topic);
		KafkaConsumerGroup kafkaConsumerGroup = new KafkaConsumerGroup(url+zookeeperTopic, "storm",
				new String[] {topic}, this);
		kafkaConsumerGroup.run(1);
	}
	
	
	
	public static void main(String[] args)
	{
		TestKafkaConnection connection = new TestKafkaConnection("192.168.99.101:", 9092, 2181, "SEPA.SEP.NYC.Taxi");
		
//		for(int i = 0; i < MAX_MESSAGES; i++)
//		{
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			connection.publishMessage(RandomStringUtils.randomAlphabetic(12).getBytes());
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		
	}
	
	public void publishMessage(byte[] bytes)
	{
		producer.send(bytes);
	}
	
	


	@Override
	public void onEvent(String json) {
		counter++;
		if (counter % 10000 == 0) System.out.println("Counter, "+ counter);
	}
	
	
}
