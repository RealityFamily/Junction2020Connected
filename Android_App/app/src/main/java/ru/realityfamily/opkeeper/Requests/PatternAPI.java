package ru.realityfamily.opkeeper.Requests;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import ru.realityfamily.opkeeper.Models.Pattern;

public interface PatternAPI {
    @Headers({
            "Accept: application/json",
            "Auth: 5e6c501b-2387-439b-801f-acdfdea49c3d"
    })
    @GET("/patterns")
    Call<List<Pattern>> getPatterns();

    @Headers({
            "Accept: application/json",
            "Auth: 5e6c501b-2387-439b-801f-acdfdea49c3d"
    })
    @GET("/pattern/{patternId}")
    Call<List<Pattern>> getPattern(@Path("patternId") String patternId);

    @Headers({
            "Accept: application/json",
            "Auth: 5e6c501b-2387-439b-801f-acdfdea49c3d",
            "Content-type: application/json"
    })
    @POST("/pattern")
    Call<ResponseBody> postPattern(@Body Pattern pattern);
}
