package com.example.ief.notekeeperpluralsight;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by ief on 24/11/2017.
 */

public final class NoteKeeperProviderContract {
    private NoteKeeperProviderContract() {}

    public  static final String AUTHORITY = "com.example.ief.notekeeperpluralsight.provider";
    public static final Uri AUTHORITY_URI = Uri.parse("content://" + AUTHORITY);

    protected interface CoursesIdColumns {
        public static final String COLUMN_COURSE_ID = "course_id";
    }
    protected interface CoursesColumns {
        public static final String COLUMN_COURSE_TITLE = "course_title";
    }
    protected interface NoteColumns {
        public static final String COLUMN_NOTE_TITLE = "note_title";
        public static final String COLUMN_NOTE_TEXT = "note_text";
    }
    public static final class Courses implements BaseColumns, CoursesColumns, CoursesIdColumns {
        public static final String PATH = "courses";
        // content://com.example.ief.notekeeperpluralsight.provider/courses
        public static final Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI, PATH);
    }
    //de coursescolumns van notes zijn enkel toegankelijk via de notes_expanded
    public static final class Notes implements BaseColumns, NoteColumns, CoursesIdColumns, CoursesColumns {
        public static final String PATH = "notes";
        public static final Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI, PATH);
        public static final String PATH_EXPANDED = "notes_expanded";
        public static final Uri CONTENT_EXPANDED_URI = Uri.withAppendedPath(AUTHORITY_URI, PATH_EXPANDED);
    }
}
