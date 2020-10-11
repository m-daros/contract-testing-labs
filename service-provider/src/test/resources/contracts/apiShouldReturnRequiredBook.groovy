package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description ("""
given:
	the service is up & running
when:
	you get /api/v1/books
then:
	you'll get the collection of books
""")
    request {
        method 'GET'
        url '/api/v1/books/1'
        headers {

            contentType ( applicationJson () )
        }
    }
    response {
        status 200
        body (
                // As a workaround, the regex specify a LocalDateTime in string format since anyDateTime () doesn't work
                [ "id": anyInteger (), "publishDate": regex ( "([0-9]{4})-(1[012]|0[1-9])-(2[0-8]|1[1-9]|0[1-9])T(2[0-3]|[01][0-9]):([0-5][0-9]):([0-5][0-9])\\.\\d{6}" ) ]
        )
        headers {

            contentType ( applicationJson () )
        }
    }
}