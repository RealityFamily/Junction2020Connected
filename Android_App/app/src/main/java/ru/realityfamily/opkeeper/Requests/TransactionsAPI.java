package ru.realityfamily.opkeeper.Requests;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import ru.realityfamily.opkeeper.Models.Transaction;

public interface TransactionsAPI {
    @Headers({
            "Accept: application/json",
            "Auth: 5e6c501b-2387-439b-801f-acdfdea49c3d"
    })
    @GET("/deb_cred_status")
    Call<Double> getDebCredStatus();

    @Headers({
            "Accept: application/json",
            "Auth: 5e6c501b-2387-439b-801f-acdfdea49c3d"
    })
    @GET("/wrong_transaction")
    Call<Transaction> getWrongTransaction();
}
