package ru.realityfamily.opkeeper.Requests;

import java.util.List;

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
            "Auth: vgcdhkbchjdnvhjsdl"
    })
    @GET("/patterns")
    Call<List<Pattern>> getPatterns();

    @Headers({
            "Accept: application/json",
            "Auth: vgcdhkbchjdnvhjsdl"
    })
    @GET("/pattern/{patternId}")
    Call<List<Pattern>> getPattern(@Path("patternId") String patternId);

    @Headers({
            "Accept: application/json",
            "Auth: vgcdhkbchjdnvhjsdl"
    })
    @POST("/pattern")
    Call<Response> postPattern(@Body Pattern pattern);
}
