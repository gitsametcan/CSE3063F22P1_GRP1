from datetime import datetime
import sys

class Logger :
    __loggers = dict()

    @classmethod
    def getLogger(cls,fileNameWithoutExtension : str):
        # this function retrieves the logger 
        # object corresponding to the given name
        
        # if the given name is contained in keys of loggers
        # return that logger object
        if (fileNameWithoutExtension in cls.__loggers):
            return cls.__loggers[fileNameWithoutExtension]
        
        # otherwise generate a new logger object and return it
        tLog = Logger(fileNameWithoutExtension)
        cls.__loggers[fileNameWithoutExtension] = tLog
        return tLog

    def __init__(self, fileNameWithoutExtension: str):
        # current date is retrieved 
        # to be used as file name
        now = datetime.now()
        date = now.strftime("%Y-%m-%d-%H-%M-%S")

        import DataManager

        metaData = DataManager.DataManager.getInstance().getMetaData()
        logsFolder = metaData["logsPath"]

        # to create file with given name
        # because otherwise open for append fails
        try:
            fp = open(logsFolder + date + "_" + fileNameWithoutExtension + ".txt", "x")
            fp.close()
        except FileNotFoundError:
            print("{logs} folder is not present in current working directory. Consider creating this path and try again.".format(logs=logsFolder), file=sys.stderr)
            sys.exit("Quitting.")

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
        self.__log("[ERROR]", message)

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
        self.__log("[INFO]", message)

    def __log(self, tag,  text):
        # retrieving current date and time
        # to print with log message
        now = datetime.now()
        date = now.strftime("%Y-%m-%d-%H-%M-%S")
        currentTime = "[" + date + "]"
        
        # concatanates current time, tag and message
        message = currentTime + tag + " " + str(text)
        if ( "ERROR" in tag ):
            # prints the message to the stderr
            # if the tag contains "ERROR"
            print(str(text), file=sys.stderr)
        if ( "INFO" in tag ):
            # prints the message to the stdout
            # if the tag contains "INFO"
            print(str(text))
        
        # prints the message as a new line to the file
        self.outputFile.write(message + str('\n'))
        # flushes it so that it is applied
        self.outputFile.flush()