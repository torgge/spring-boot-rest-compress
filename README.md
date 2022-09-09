# spring-boot-rest-compress

Proof of concept to use Gzipped compressed message handle

> Post Method
>

```
POST http://localhost:8099/compress/process
Content-Type: application/json;charset=UTF-8
Content-Encoding: gzip

{
  "text": "oversize text"
}
```
### Curl

````shell
echo '{"text": "032208"}' | gzip | curl -v -i --data-binary @- -H "Content-Encoding: gzip" -H "Content-Type: application/json;charset=UTF-8" http://localhost:8099/compress/process
````
````shell
#To reference a gzipped file
curl -v -i --data-binary @body.gz -H "Content-Encoding: gzip" -H "Content-Type: application/json;charset=UTF-8" http://localhost:8099/compress/process
````


---
### References

- https://www.baeldung.com/spring-resttemplate-compressing-requests
- https://github.com/eugenp/tutorials/tree/master/spring-web-modules/spring-resttemplate-2
