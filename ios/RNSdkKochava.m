#import "RNSdkKochava.h"
#import "KochavaTracker.h"

@implementation RNSdkKochava

- (dispatch_queue_t)methodQueue
{
    return dispatch_get_main_queue();
}

+ (BOOL)requiresMainQueueSetup
{
    return YES;
}

RCT_EXPORT_MODULE()

RCT_EXPORT_METHOD(logCustomEvent:(nonnull NSString*)evtName withParams:(NSDictionary *)params) {
    [KochavaTracker.shared sendEventWithNameString:evtName
                                    infoDictionary:params];
}

@end
  
