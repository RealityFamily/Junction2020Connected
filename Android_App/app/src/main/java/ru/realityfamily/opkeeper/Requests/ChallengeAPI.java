package ru.realityfamily.opkeeper.Requests;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import ru.realityfamily.opkeeper.Adapters.DashboardAdapter;
import ru.realityfamily.opkeeper.Models.Challenge;

public interface ChallengeAPI {
    @Headers({
            "Accept: application/json",
            "Auth: vgcdhkbchjdnvhjsdl"
    })
    @GET("/challegges")
    Call<List<DashboardAdapter.SmallInfo>> getChallenges();

    @Headers({
            "Accept: application/json",
            "Auth: vgcdhkbchjdnvhjsdl"
    })
    @GET("/challenge/{challengeId}")
    Call<Challenge> getChallenge(@Path("challengeId") String challengeId);

    @Headers({
            "Accept: application/json",
            "Auth: vgcdhkbchjdnvhjsdl"
    })
    @POST("/challenge")
    Call<Response> postChallenge (@Body Challenge challenge);

    @Headers({
            "Accept: application/json",
            "Auth: vgcdhkbchjdnvhjsdl"
    })
    @POST("/challenge_post_instagram")
    Call<Response> postChallengeToInstagram (@Body String id);

    @Headers({
            "Accept: application/json",
            "Auth: vgcdhkbchjdnvhjsdl"
    })
    @POST("/challenge_post_facebook")
    Call<Response> postChallengeToFacebook (@Body String id);
}
