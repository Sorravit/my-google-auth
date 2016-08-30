# my-google-auth
Generate OTP from command line instead of Google Authenticator in mobile phone.

# How to use
1. Store secret in file for example `/home/mac/config`
2. Run `java -jar my-google-auth.jar /home/mac/config`
3. OTP will be copy to your clipboard and it will be valid for 30 seconds.

# Config file 

```yaml
secret: ''
prefix-password: ''
```
