# Contract Testing

During our experience as developers we always build code where components depend on other components.

If we are using typed languages, when dealing with the interaction between components on the same JVM we can take advantage of the features of the language, 
so it's immediately possible to know if the removal of an API call will break a dependant component, and it's also possible to know if we are trying to call an API that does not exist.
We can take the same advantage also dealing with data model object we use as request parameters or response objects.

How can we deal with components that are not on the same JVM, as we do in Microservices applications?

As a client microservice we configure a call to a provider microservice based on a specification, but we are unaware of future changes if the provider doesn't publish a newer version of the API, and so the call
will be broken in the future.

We need a way to define a **contract** between a provider and their clients, and we need a way to know when one of the 2 parties are breaking the contract.



![contract-testing](https://github.com/m-daros/contract-testing-labs/blob/master/docs/contract-testing.png)

