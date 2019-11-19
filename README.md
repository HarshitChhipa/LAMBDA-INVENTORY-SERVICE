# Inventory Service

### Installing npm dependencies
```bash
npm install
```
`gst

### Installing Micronaut cli

Install sdkman which will be used to install micronaut-cli
```bash
curl -s "https://get.sdkman.io" | bash
source "$HOME/.sdkman/bin/sdkman-init.sh"
```
Now run 
```bash
 sdk install micronaut <version>      //example: sdk install micronaut 1.1.3
```



### Deploy
- Set up AWS credentials locally.

```bash
npx serverless config credentials --provider aws --key <aws_key> --secret <aws_secret>
```

- Deploy the lambda functions
```bash
./gradlew deploy -Pstage=<stage>      //local by default
```

### Clean-up
- Clean up lambda functions
```bash
./gradlew destroy -Pstage=<local>
```
