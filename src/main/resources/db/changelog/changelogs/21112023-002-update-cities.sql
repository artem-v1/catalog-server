UPDATE cities
SET location = ST_SetSRID(ST_MakePoint(longitude, latitude), 4326);
