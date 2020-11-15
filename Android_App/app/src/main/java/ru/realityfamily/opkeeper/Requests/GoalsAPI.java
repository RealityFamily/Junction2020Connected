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
import ru.realityfamily.opkeeper.Models.Goal;
import ru.realityfamily.opkeeper.Models.SmallInfo;

public interface GoalsAPI {
    @Headers({
            "Accept: application/json",
            "Auth: 5e6c501b-2387-439b-801f-acdfdea49c3d"
    })
    @GET("/goals")
    Call<List<SmallInfo>> getGoals();

    @Headers({
            "Accept: application/json",
            "Auth: 5e6c501b-2387-439b-801f-acdfdea49c3d"
    })
    @GET("/goal_predict/{goalId}")
    Call<Goal> getGoal(@Path("goalId") String goalId);

    @Headers({
            "Accept: application/json",
            "Auth: 5e6c501b-2387-439b-801f-acdfdea49c3d",
            "Content-type: application/json"
    })
    @POST("/goal")
    Call<ResponseBody> postGoal(@Body Goal goal);

    @Headers({
            "Accept: application/json",
            "Auth: 5e6c501b-2387-439b-801f-acdfdea49c3d",
            "Content-type: application/json"
    })
    @DELETE("/goal/{deleteId}")
    Call<ResponseBody> deleteGoal(@Path("deleteId") UUID goalId);
}
