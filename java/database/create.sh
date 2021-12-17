#!/bin/bash
BASEDIR=$(dirname $0)
DATABASE=final_capstone
psql -U postgres -f "$BASEDIR/dropdb.sql" &&
createdb -U postgres $DATABASE &&
psql -U postgres -d $DATABASE -f "$BASEDIR/schema.sql" &&
psql -U postgres -d $DATABASE -f "$BASEDIR/user.sql" &&
psql -U postgres -d $DATABASE -f "$BASEDIR/landmarks-data.sql" &&
psql -U postgres -d $DATABASE -f "$BASEDIR/itineraries-data.sql" &&
psql -U postgres -d $DATABASE -f "$BASEDIR/landmark-likes.sql"
