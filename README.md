# spring-discovery

Handler Relational Spring Sample. It contains things that I have experienced as Java Developer at Company. Of course, it can't be the best solution for anyone. If you have better ideas, let's share with us in order to expands knowledge to our **Comunity**.

This repository contains:

###### 1. The Simplest Sample for Relational Entity in Spring JPA, Hibernate.
###### 2. Mapstruct: let's use it instead of ModelMapper, trust me, it's interesting.
###### 3. CustomRestTemplate.
###### 4. Specification JPA(feature/specification): use to build filter data URL.
``` 
With Specification JPA you can optimize the number of APIs.
Instead of using multiple APIs using to filter only one entity, 
using Specification you can filter some simple operation with just one API. 
I have made some custom to make it easier to use.

- Use this /api/user/filter?username.equal=Duy_1&name.like=Le Van
- You can get your expected result. It can help FE developer filter as if they write a SQL Query right :D.

>> In my opinion, We should use JPA Specification in order to do filter relating to 1 entity 
or use in case of inner join.
Because it always return entired object all the time.
```
###### 6. QueryDSL:

Hung from my university recommended me to use it when we worked together in his thesis project. However, at this time
I didn't know how powerfull it is :D.

There are many people getting stuck with Spring SPA when they want to write a query as it is not easy to do mapping step
from ResultSet to Entity. My company's project, they intend to use JPA Specification to replace @Query.
However, as I mentioned above, we should use Specification for filter data from 1 object, if we scale our problem to
more objects, we will cope with some issue when we fetch data. 

Therefore, my recommendation is let use QueryDSL instead of using @Query for native query.

###### 5. Updating....
