package rest

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(path = "blogEntries")
interface BlogEntryRepository : JpaRepository<BlogEntry, Int>