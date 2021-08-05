# UI Android Test Sample
UI Tests using Robolectric

The advantage of using Robolectric is that it is not necessary to have an emulator to run the tests as it is with tests using Espresso.

In this project is using the follow dependencies in the build.gradle:

    
    testImplementation 'junit:junit:4.12'
    testImplementation ("org.robolectric:robolectric:4.5.1") {
        exclude group: "org.apache.maven.wagon"
        exclude group: "org.apache.maven"
    }

    // Core library
    testImplementation 'androidx.test:core:1.4'

    // AndroidJUnitRunner and JUnit Rules
    testImplementation 'androidx.arch.core:core-testing:2.1.0'
    testImplementation 'androidx.test:runner:1.4'
    testImplementation 'androidx.test.ext:junit:1.1.3'
    testImplementation 'androidx.test.espresso:espresso-core:3.4.0'
    
#### NOTE: use "testImplementation" like in unit tests, because you don't need an emulator to run this tests.

## How to run the tests:

    ./gradlew test
