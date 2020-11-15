package ru.realityfamily.opkeeper.Requests;

import java.util.List;
import java.util.UUID;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import ru.realityfamily.opkeeper.Adapters.DashboardAdapter;
import ru.realityfamily.opkeeper.Models.Challenge;
import ru.realityfamily.opkeeper.Models.SmallInfo;
import ru.realityfamily.opkeeper.R;

public interface ChallengeAPI {
    @Headers({
            "Accept: application/json",
            "Auth: 5e6c501b-2387-439b-801f-acdfdea49c3d"
    })
    @GET("/challenges")
    Call<List<SmallInfo>> getChallenges();

    @Headers({
            "Accept: application/json",
            "Auth: 5e6c501b-2387-439b-801f-acdfdea49c3d"
    })
    @GET("/challenge/{challengeId}")
    Call<Challenge> getChallenge(@Path("challengeId") String challengeId);

    @Headers({
            "Accept: application/json",
            "Auth: 5e6c501b-2387-439b-801f-acdfdea49c3d"
    })
    @POST("/challenge")
    Call<ResponseBody> postChallenge (@Body Challenge challenge);

    @Headers({
            "Accept: application/json",
            "Auth: 5e6c501b-2387-439b-801f-acdfdea49c3d",
            "Content-type: application/json"
    })
    @DELETE("/challenge/{deleteId}")
    Call<ResponseBody> deleteChallenge(@Path("deleteId") UUID challengeId);

    @Headers({
            "Accept: application/json",
            "Auth: 5e6c501b-2387-439b-801f-acdfdea49c3d",
            "Content-type: application/json"
    })
    @POST("/challenge_post_instagram")
    Call<ResponseBody> postChallengeToInstagram (@Body String id);

    @Headers({
            "Accept: application/json",
            "Auth: 5e6c501b-2387-439b-801f-acdfdea49c3d",
            "Content-type: application/json"
    })
    @POST("/challenge_post_facebook")
    Call<ResponseBody> postChallengeToFacebook (@Body String id);
}
