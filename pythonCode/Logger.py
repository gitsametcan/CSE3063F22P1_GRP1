from datetime import datetime
import sys

class Logger :
    _loggers = dict()

    @classmethod
    def getLogger(cls,fileNameWithoutExtension):
        # this function retrieves the logger 
        # object corresponding to the given name

        # if a dictionary is not present, generate one
        #try:
         #   val = cls._loggers
        #except NameError:
         #   cls._loggers = dict()
        
        # if the given name is contained in keys of loggers
        # return that logger object
        if (fileNameWithoutExtension in cls._loggers):
            return cls._loggers[fileNameWithoutExtension]
        
        # otherwise generate a new logger object and return it
        tLog = Logger(fileNameWithoutExtension)
        cls._loggers[fileNameWithoutExtension] = tLog
        return tLog

    def __init__(self, fileNameWithoutExtension):
        # current date is retrieved 
        # to be used as file name
        now = datetime.now()
        date = now.strftime("%Y-%m-%d-%H-%M-%S")

        import DataManager

        metaData = DataManager.DataManager.getInstance().getMetaData()
        logsFolder = metaData["logsPath"]

        # to create file with given name
        # because otherwise open for append fails
        fp = open(logsFolder + date + "_" + fileNameWithoutExtension + ".txt", "x")
        fp.close()

        # opens the file to append
        self.outputFile = open(logsFolder + date + "_" + fileNameWithoutExtension + ".txt", "a", encoding="utf-8")

    def error(self, text, *args):
        # to be able to access 
        # message var outside the if scope
        message = ''

        # checks if args are present
        if len(args) > 0:
            # formats the string depending on the args
            message = text.format(args)
        else:
            message = text
        
        # appends [ERROR] at the start of message and prints
        self.log("[ERROR]", message)

    def info(self, text, *args):
        # to be able to access 
        # message var outside the if scope
        message = ''

        # checks if args are present
        if len(args) > 0:
            # formats the string depending on the args
            message = text.format(args)
        else:
            message = text
        
        # appends [INFO] at the start of message and prints
        self.log("[INFO]", message)

    def log(self, tag,  text):
        # retrieving current date and time
        # to print with log message
        now = datetime.now()
        date = now.strftime("%Y-%m-%d-%H-%M-%S")
        currentTime = "[" + date + "]"
        
        # concatanates current time, tag and message
        message = currentTime + tag + text
        if ( "ERROR" in tag ):
            # prints the message to the stderr
            # if the tag contains "ERROR"
            print(message, file=sys.stderr)
        if ( "INFO" in tag ):
            # prints the message to the stdout
            # if the tag contains "INFO"
            print(message)
        
        # prints the message as a new line to the file
        self.outputFile.write(message + str('\n'))
        # flushes it so that it is applied
        self.outputFile.flush()