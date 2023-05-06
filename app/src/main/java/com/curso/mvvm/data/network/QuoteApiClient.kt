package com.curso.mvvm.data.network

import com.curso.mvvm.data.model.QuoteModel
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface QuoteApiClient { //TODO: route specific that api (root api is in core.retrofitHelper)

    @GET("/.json") //original call
    suspend fun getAllQuotes(): Response<List<QuoteModel>> //get list(json) each Quote

    //retrofit advance below
    @GET
    fun getCharacterByName(@Url url: String): Call<DogsResponse>

    @GET("/example/example2/{id}/loquesea")// need path (id)
    fun getCharacterByName2(@Path("id") id: String): Call<DogsResponse>

    @GET("/example/example2/v2/loquesea")
    fun getCharacterByName3(
        @Query("pet") pet: String,//add two values
        @Query("name") name: String//add two values
    ): Call<DogsResponse>

    @POST
    fun getEVERYTHING(@Body exampleParameterDto: ExampleParameterDto): Call<*>

    @Multipart // split call send. image
    @POST
    fun getEVERYTHING2(
        @Part image: MultipartBody.Part,
        @Part("example") myExample: String
    ): Call<*>


//    val requestBody =   RequestBody.create(MediaType.parse(getContentResolver().getType(fileUri)), file);
//    val a = MultipartBody.Part.createFormData("picture", file.getName(), requestBody);
}

data class ExampleParameterDto(val name: String, val age: Int)  //create for example method post recommend move other directory
