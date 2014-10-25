/*
 * Copyright (C) 2011 Markus Junginger, greenrobot (http://greenrobot.de)
 *
 * This file is part of greenDAO Generator.
 * 
 * greenDAO Generator is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * greenDAO Generator is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with greenDAO Generator.  If not, see <http://www.gnu.org/licenses/>.
 */
package de.greenrobot.dao.test;

import android.database.Cursor;
import java.io.IOException;
import de.greenrobot.dao.DbUtils;

public class DbUtilsTest extends DbTest {
    public void testExecuteSqlScript() throws IOException {
        DbUtils.executeSqlScript(getContext(), db, "minimal_entity.sql");
        Cursor cursor = db.rawQuery("SELECT count(*) from MINIMAL_ENTITY", null);
        try {
            cursor.moveToFirst();
            assertEquals(5, cursor.getInt(0));
        } finally {
            cursor.close();
        }
    }

}
