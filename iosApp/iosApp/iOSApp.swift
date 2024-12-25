import SwiftUI
import shared // Import the shared module

@main
struct iOSApp: App {
    init() {
        KoinKt.doInitKoin()
    }

	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}