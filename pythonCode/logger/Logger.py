from datetime import datetime
import sys

class Logger :
    loggers = None

    @staticmethod
    def  getLogger(fileNameWithoutExtension):
        if (loggers is None) :
            loggers =  dict()
        if ((fileNameWithoutExtension in loggers.keys())) :
            return loggers.get(fileNameWithoutExtension)
        tLog = Logger(fileNameWithoutExtension)
        loggers[fileNameWithoutExtension] = tLog
        return tLog

    def __init__(self, fileNameWithoutExtension) :
        now = datetime.now()
        date = now.strftime("%Y-%m-%d-%H-%M-%S")
        self.outputFile = open(date + "_" + fileNameWithoutExtension + ".txt", "a", encoding="utf-8")

    def error(self, text, *args):
        message = ''
        if len(args) > 0:
            message = text.format(args)
        else:
            message = text
        self.log("[ERROR]", message)

    def info(self, text, *args) :
        message = ''
        if len(args) > 0:
            message = text.format(args)
        else:
            message = text
        self.log("[INFO]", message)

    def log(self, tag,  text) :
        now = datetime.now()
        date = now.strftime("%Y-%m-%d-%H-%M-%S")
        currentTime = "[" + date + "]"
        message = currentTime + tag + text
        if ( "ERROR" in tag ) :
            print(message, file=sys.stderr)
        if ( "INFO" in tag ) :
            print(message)
        self.outputFile.write(message + str('\n'))
        self.outputFile.flush()