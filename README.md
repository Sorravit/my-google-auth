# my-google-auth
Generate OTP from command line instead of Google Authenticator in mobile phone.

#To use the program
you can either
```clone the repo and run mvn package```
or download the complied version from https://github.com/Sorravit/my-google-auth/blob/master/CompliedVersion/my-google-auth.jar

# How to use
1. Store secret in file for example `/home/mac/config`
2. Run `java -jar my-google-auth.jar /home/mac/config`
3. OTP will be copy to your clipboard and it will be valid for 30 seconds.

# Config file 

- secret : Your secret key
- prefix-password (Optional) : Your static password. I recommend you leave it blank.

## Example 

```yaml
secret: ''
prefix-password: ''
```

# Credit

This is the library that I use for generating OTP : https://github.com/aerogear/aerogear-otp-java
