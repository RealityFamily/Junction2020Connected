package ru.realityfamily.opkeeper.Requests;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import ru.realityfamily.opkeeper.Models.Transaction;

public interface TransactionsAPI {
    @Headers({
            "Accept: application/json",
            "Auth: vgcdhkbchjdnvhjsdl"
    })
    @GET("/deb_cred_status")
    Call<Integer> getDebCredStatus();

    @Headers({
            "Accept: application/json",
            "Auth: vgcdhkbchjdnvhjsdl"
    })
    @GET("/wrong_transaction")
    Call<Transaction> getWrongTransaction();
}
