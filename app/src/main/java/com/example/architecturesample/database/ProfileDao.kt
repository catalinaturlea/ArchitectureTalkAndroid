package com.example.architecturesample.database

import androidx.room.*
import io.reactivex.Flowable

@Dao
interface ProfileDao {

    @Query("SELECT * FROM profiles")
    fun getProfiles(): Flowable<List<Profile>>

    @Query("SELECT * FROM profiles WHERE id IN (:accountIds)")
    fun getProfiles(accountIds: List<Int>) : Flowable<List<Profile>>

    @Query("SELECT * FROM profiles WHERE id = :accountId")
    fun getProfile(accountId: Int) : Flowable<Profile>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProfile(profile: Profile)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProfiles(profiles: List<Profile>)

    @Delete
    fun deleteProfile(profile: Profile)

    @Query("DELETE FROM profiles")
    fun deleteAllProfiles()
}
