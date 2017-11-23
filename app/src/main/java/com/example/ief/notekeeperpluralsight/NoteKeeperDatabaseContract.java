package com.example.ief.notekeeperpluralsight;

import android.provider.BaseColumns;

/**
 * Created by ief on 9/11/2017.
 */

public final class NoteKeeperDatabaseContract {
    private NoteKeeperDatabaseContract() {} //makes non-creatable

    public static final class CourseInfoEntry implements BaseColumns{
        public static final String TABLE_NAME = "course_info";
        public static final String COLUMN_COURSE_ID = "course_id";
        public static final String COLUMN_COURSE_TITLE  = "course_title";

        // CREATE INDEX       of CREATE UNIQUE INDEX (dwingt uniek af op de kolom).
        // indexen verhogen de performantie van sommige queries, wordt gebruikt door de DB zelf queries moeten niet gewijzigd worden

        // CREATE INDEX  course_info_index1 ON course_info (course_title,...)
        public static final String INDEX1 = TABLE_NAME + "_index1";
        public static final String SQL_CREATE_INDEX1 =
                "CREATE INDEX " + INDEX1 + " ON " + TABLE_NAME +
                        "(" + COLUMN_COURSE_TITLE + ")";

        // kolommen met zelfde naam in joins moeten uniek gedeclareerd worden
        public static final String getQName(String columnName){
            return TABLE_NAME + "." + columnName;
        }

        //  CREATE TABLE Course_info (course_id, course_title)
        public static final String SQL_CREATE_TABLE =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        _ID + " INTEGER PRIMARY KEY, " +
                        COLUMN_COURSE_ID + " TEXT UNIQUE NOT NULL, " +
                        COLUMN_COURSE_TITLE + " TEXT NOT NULL)";

    }



    public static final class NoteInfoEntry implements BaseColumns{
        public static final String TABLE_NAME = "note_info";
        public static final String COLUMN_NOTE_TITLE = "note_title";
        public static final String COLUMN_NOTE_TEXT = "note_text";
        public static final String COLUMN_COURSE_ID = "course_id";


        // CREATE INDEX       of CREATE UNIQUE INDEX (dwingt uniek af op de kolom).
        // indexen verhogen de performantie van sommige queries, wordt gebruikt door de DB zelf queries moeten niet gewijzigd worden

        // CREATE INDEX  note_info_index1 ON note_info ("note_title,...)
        public static final String INDEX1 = TABLE_NAME + "_index1";
        public static final String SQL_CREATE_INDEX1 =
                "CREATE INDEX " + INDEX1 + " ON " + TABLE_NAME +
                        "(" + COLUMN_NOTE_TITLE + ")";

        // kolommen met zelfde naam in joins moeten uniek gedeclareerd worden
        public static final String getQName(String columnName){
            return TABLE_NAME + "." + columnName;
        }

        public static final String SQL_CREATE_TABLE =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        _ID + " INTEGER PRIMARY KEY, " +
                        COLUMN_NOTE_TITLE + " TEXT NOT NULL, " +
                        COLUMN_NOTE_TEXT + " TEXT, " +
                        COLUMN_COURSE_ID + " TEXT NOT NULL)";
    }
 }
