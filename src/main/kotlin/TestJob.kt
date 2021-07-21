import io.quarkus.runtime.Startup
import org.quartz.JobExecutionContext
import org.quartz.Scheduler
import javax.inject.Singleton

@Startup
@Singleton
class TestJob(scheduler: Scheduler) : BaseJob(scheduler = scheduler) {

    init {
        println("class used for bean resolving: ${this::class.java}")
    }

    override fun getCron(): String {
        return "0/15 * * ? * * *"
    }

    override fun execute(context: JobExecutionContext) {
        println("executing TestJob")
    }
}