import { Kafka, Consumer } from 'kafkajs';

class KafkaService {
  private kafka: Kafka;
  private consumer: Consumer;
  private topic: string = 'entityA-topic';

  constructor() {
    this.kafka = new Kafka({
      clientId: 'my-app',
      brokers: ['localhost:9092']  // Adaptez avec vos serveurs Kafka
    });

    this.consumer = this.kafka.consumer({ groupId: 'test-group' });

    this.initializeConsumer();
  }

  private async initializeConsumer(): Promise<void> {
    await this.consumer.connect();
    await this.consumer.subscribe({ topic: this.topic, fromBeginning: true });

    await this.consumer.run({
      eachMessage: async ({ topic, partition, message }) => {
        console.log({
          value: message!.value!.toString(),
          topic,
          partition,
        });
        // Ici vous pouvez traiter les messages reçus, par exemple les stocker ou les utiliser dans des logiques métier
      }
    });
  }
}

export default new KafkaService();
