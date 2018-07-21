The api which is being used to fetch the bitcoin details is
    https://min-api.cryptocompare.com/data/histominute?fsym=BTC&tsym=GBP
        or to fetch in terms of limit
    https://min-api.cryptocompare.com/data/histominute?fsym=BTC&tsym=GBP&limit=3

Tha above returns the data of one day or 24 hours or 24*60 + 1 minutes. So we now make an array of 1440 + 1 = 1441.

The approach taken is listed down as a sequence of steps
    1. Took a singleton bean which has values stores as follows
        - bitcoinValues[] which stores the bitcoinValues of each and every minute.
            The last index stores the value of currentMinute.
        - averageValues[] which calulates the average of the bitcoinValues sequentially from end to start.
        - currentTimestamp which stores the update timestamp when the client used to fetch the details.

        And on initialization of spring ccntainer, in the beans postprocessing just making a call to the rest api
        and fetching the data and updating the value to the beans instance variables.

    2. We have three layers here
        - Controller layer
                The Controller Layer has the following URL as
                    localhost:8080/bitcoinapp/cryptoDetails?underSpecifiedTime=1000 (where 1000 is X as listed in the problem statement)
        - Service Layer
                In The service layer we provide the logic for updating the Singleton bean based on conditions
                    if (clientRequestedTimestamp - currentServerTimestampMinutes >= 1) {
                        Then fetch the api's with limit as only being the difference in minutes and update the BitcoinInformationBean
                        Just shift the arrays values and also process the averageValues array
                    } else {
                        Then just retrieve the details from the stored values.
                    }

        - Repository Layer
                This layer is used to fetch the CustomResponseBody which is the json to be viewed by client
                - Median
                - Average

    3. Sample

    Request - http://localhost:8080/bitcoinapp/cryptoDetails?underSpecifiedTime=1000

    Response - {"average":5558.744869999999,"median":5565.64}


