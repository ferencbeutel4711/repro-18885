import org.quartz.CronScheduleBuilder
import org.quartz.Job
import org.quartz.JobBuilder
import org.quartz.Scheduler
import org.quartz.Trigger
import org.quartz.TriggerBuilder

abstract class BaseJob(scheduler: Scheduler) : Job {
    init {
        val job = JobBuilder.newJob(this::class.java).build()
        val trigger: Trigger = TriggerBuilder.newTrigger()
                .withSchedule(CronScheduleBuilder.cronSchedule(this.getCron()))
                .build()

        scheduler.scheduleJob(job, trigger)
    }

    abstract fun getCron(): String
}
