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
import ru.realityfamily.opkeeper.Models.Goal;

public interface GoalsAPI {
    @Headers({
            "Accept: application/json",
            "Auth: vgcdhkbchjdnvhjsdl"
    })
    @GET("/goals")
    Call<List<DashboardAdapter.SmallInfo>> getGoals();

    @Headers({
            "Accept: application/json",
            "Auth: vgcdhkbchjdnvhjsdl"
    })
    @GET("/goal_predict/{goalId}")
    Call<Goal> getGoal(@Path("goalID") String goalId);

    @Headers({
            "Accept: application/json",
            "Auth: vgcdhkbchjdnvhjsdl"
    })
    @POST("/goal")
    Call<Response> postGoal(@Body Goal goal);
}
