

## Command to execute for creating the template:

```
mvn compile exec:java \
  -Dexec.mainClass=com.viveknaskar.DataFlowPipelineForMemStore \
  -Dexec.args="--project=your-project-id \
  --jobName=dataflow-memstore-job \
  --inputFile=gs://cloud-dataflow-input-bucket/*.txt \
  --redisHost=127.0.0.1 \
  --stagingLocation=gs://dataflow-pipeline-batch-bucket/staging/ \
  --dataflowJobFile=gs://dataflow-pipeline-batch-bucket/templates/dataflow-custom-redis-template \
  --gcpTempLocation=gs://dataflow-pipeline-batch-bucket/tmp/ \
  --runner=DataflowRunner"
```

## Check the data inserted in Memorystore (Redis) datastore
For checking whether the processed data is stored in the Redis instance after the dataflow pipeline is executed successfully, you must first connect to the Redis instance from any Compute Engine VM instance located within the same project, region and network as the Redis instance.

1) Create a VM instance and SSH to it

2) Install telnet from apt-get in the VM instance
```
  sudo apt-get install telnet
```
3) From the VM instance, connect to the ip-address of the redis instance
```
  telnet instance-ip-address 6379
```
4) Once you are in the redis, check the keys inserted
```
  keys *
```
5) Check with individual entry using the below command to get the guid
```
  smembers titles:user_1
```
6) Command to clear the redis data store
```
  flushall
```

### References

https://redis.io/topics/data-types-intro 

https://beam.apache.org/documentation/programming-guide/

https://thedeveloperstory.com/2020/07/24/cloud-dataflow-a-unified-model-for-batch-and-streaming-data-processing/ 
