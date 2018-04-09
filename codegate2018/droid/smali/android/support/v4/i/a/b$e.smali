.class Landroid/support/v4/i/a/b$e;
.super Landroid/support/v4/i/a/b$d;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/v4/i/a/b;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "e"
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    invoke-direct {p0}, Landroid/support/v4/i/a/b$d;-><init>()V

    return-void
.end method


# virtual methods
.method public a(IIIIZZ)Ljava/lang/Object;
    .locals 1

    invoke-static/range {p1 .. p6}, Landroid/view/accessibility/AccessibilityNodeInfo$CollectionItemInfo;->obtain(IIIIZZ)Landroid/view/accessibility/AccessibilityNodeInfo$CollectionItemInfo;

    move-result-object v0

    return-object v0
.end method

.method public a(IIZI)Ljava/lang/Object;
    .locals 1

    invoke-static {p1, p2, p3, p4}, Landroid/view/accessibility/AccessibilityNodeInfo$CollectionInfo;->obtain(IIZI)Landroid/view/accessibility/AccessibilityNodeInfo$CollectionInfo;

    move-result-object v0

    return-object v0
.end method
