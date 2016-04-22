THis project explores spring rest backend features.
So far the following has been explored.
1. Entity level validation based on java bean validation and throwing of standard HTTP errors by Spring framework
itself.
2. Intercepting beforeSave event, to do any kind of business logic which can be any of the following:
    1. Looking up and validating against some data
    2. Saving data into tables not behind the entity, especially useful for Cassandra since it may have Lookup tables
    3. Any thing, really, the only limitation is that the data available is limited by the projection/entity exposed
    by the end point.

