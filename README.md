By default log level in spring boot is INFO.
#HOW TO CUSTOMIZE LOG LEVELS IN SPRING BOOT
* we can set log levels according to our requirement in application.properties file
* format---  logging.level.[classpath]=[level]
 ex- logging.level.com.logging=TRACE
we can also set different log levels for different classes

*logging.level.root=INFO
logging.level.com.logging=DEBUG
from this configuration every class except the logging class path will have their log levels set to INFO

*DEFAULT LOG FORMAT-
Date and Time - Log Level -Process ID -Thread name - Logger name - Log message
* we can customize default log formatter by setting colors,message,format
   etc according to our requirement
  to enable colors
  spring.output.ansi.enabled=always , add this in application.properties file

* HANDLERS FOR SLF4J Logs
* we can display the logs in console or we can store the log messages as file.
* we can set file path and pattern in application.properties.file
  logging.file.name=loggers.log

    logging.pattern.file=%d{yyyy-MM-dd HH:mm:ss.SSS}[%level]%c{1.} [%t]%m%n
  *the logs stored in logger.log file if it exists or else a new file is created.
  *the logs keep getting stored in the file and updates itself every time the code is executed

  
